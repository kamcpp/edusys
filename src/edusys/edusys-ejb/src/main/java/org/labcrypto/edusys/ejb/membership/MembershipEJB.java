package org.labcrypto.edusys.ejb.membership;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
@Local(Membership.class)
public class MembershipEJB implements Membership {

    @Inject
    private PrincipleRepository principalRepository;

    @Inject
    private TokenGenerator tokenGenerator;

    @Inject
    private TokenRepository tokenRepository;

    @Inject
    private MembershipPolicy membershipPolicy;

    @Override
    public Token authenticate(Credential credential) throws InvalidCredentialException, BadCredentialException, ServerException, MembershipPolicyException {
        if (!membershipPolicy.allowsAuthentication(credential)) {
            throw new MembershipPolicyException();
        }
        if (credential instanceof UsernamePasswordCredential) {
            throw new InvalidCredentialException("Credential not supported.");
        }
        membershipPolicy.submitAuthenticateRequest(credential);
        Principal principal;
        try {
            principal = principalRepository.findByCredential(credential);
        } catch (PrincipleNotFoundException e) {
            membershipPolicy.submitAuthenticationFailure(credential);
            throw new BadCredentialException(e);
        }
        if (principal == null) {
            membershipPolicy.submitAuthenticationFailure(credential);
            throw new BadCredentialException();
        }
        membershipPolicy.submitAuthenticationSuccess(credential);
        Token token = null;
        boolean shouldGenerateToken = false;
        try {
            if (principalRepository.hasActiveToken(principal)) {
                token = principalRepository.getActiveToken(principal);
                try {
                    internalValidateToken(token);
                } catch (InvalidTokenException | ExpiredTokenException e) {
                    shouldGenerateToken = true;
                }
                if (token.expired()) {
                    shouldGenerateToken = true;
                }
            } else {
                shouldGenerateToken = true;
            }
            if (shouldGenerateToken) {
                token = tokenGenerator.generate(credential, principal);
                principalRepository.registerToken(principal, token);
            }
            if (token == null) {
                throw new ServerException("Something went wrong!");
            }
            return token;
        } catch (PrincipleNotFoundException e) {
            membershipPolicy.submitAuthenticationFailure(credential);
            throw new BadCredentialException(e);
        }
    }

    @Override
    public void validateToken(Token token) throws InvalidTokenException, ExpiredTokenException, ServerException {
        internalValidateToken(token);
    }

    @Override
    public void disableToken(Token token) throws InvalidTokenException, ExpiredTokenException, ServerException {
        internalValidateToken(token);
        try {
            tokenRepository.disableToken(token);
        } catch (TokenNotFoundException e) {
            throw new InvalidTokenException(e);
        }
    }

    @Override
    public List<Role> getRoles(Token token) throws InvalidTokenException, ExpiredTokenException, ServerException {
        try {
            internalValidateToken(token);
            Principal principal = principalRepository.findByToken(token);
            return principal.roles();
        } catch (PrincipleNotFoundException e) {
            throw new InvalidTokenException(e);
        }
    }

    private void internalValidateToken(Token token) throws InvalidTokenException, ExpiredTokenException, ServerException {
        Token actualToken;
        try {
            actualToken = tokenRepository.findByValue(token.value());
        } catch (TokenNotFoundException e) {
            throw new InvalidTokenException(e);
        }
        if (actualToken == null) {
            throw new InvalidTokenException();
        }
        if (actualToken.expired() || actualToken.disabled()) {
            throw new ExpiredTokenException();
        }
        long now = new Date().getTime();
        if (actualToken.issueDate() + actualToken.duration() * 60000 < now) {
            try {
                tokenRepository.expireToken(actualToken);
            } catch (TokenNotFoundException e) {
            }
            throw new ExpiredTokenException();
        }
    }
}
