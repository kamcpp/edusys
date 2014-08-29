package com.mftvanak.edusys.ws.messaging.endpoints;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.ColorType;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.messaging.TodoItem;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TodoItemNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.messaging.schemas.AddTodoItemRequest;
import com.mftvanak.edusys.ws.messaging.schemas.AddTodoItemResponse;
import com.mftvanak.edusys.ws.messaging.schemas.DeleteTodoItemRequest;
import com.mftvanak.edusys.ws.messaging.schemas.DeleteTodoItemResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemByIdRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemByIdResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemsAssignedByPersonRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemsAssignedByPersonResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemsForPersonRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemsForPersonResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemsRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetTodoItemsResponse;
import com.mftvanak.edusys.ws.messaging.schemas.UpdateTodoItemRequest;
import com.mftvanak.edusys.ws.messaging.schemas.UpdateTodoItemResponse;
import com.mftvanak.edusys.ws.messaging.schemas.types.TodoItemType;
import com.mftvanak.edusys.ws.messaging.services.AuditService;
import com.mftvanak.edusys.ws.messaging.services.PersonnelService;
import com.mftvanak.edusys.ws.messaging.services.SecurityService;
import com.mftvanak.edusys.ws.messaging.services.TodoItemService;


@Endpoint
public class TodoServiceEndpoint {

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @Autowired
  private PersonnelService personnelService;

  @Autowired
  private TodoItemService todoItemService;

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "AddTodoItemRequest")
  public @ResponsePayload
  AddTodoItemResponse handleAddTodoItemRequest (@RequestPayload AddTodoItemRequest request) throws ClientInformationNeededException,
      UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, PersonNotFoundException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "AddTodoItem", "TodoService", "0.0.1",
          "Adding todoItem '" + request.getTodoItem ().getSubject () + "' ...", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person owner = personnelService.getPersonById (request.getTodoItem ().getOwnerId ());
    if (owner == null) {
      throw new PersonNotFoundException ();
    }
    Person receiver = personnelService.getPersonById (request.getTodoItem ().getReceiverId ());
    if (receiver == null) {
      throw new PersonNotFoundException ();
    }
    TodoItem todoItem = new TodoItem ();
    if (request.getTodoItem ().getColor () != null) {
      todoItem.setColor (ColorType.valueOf (request.getTodoItem ().getColor ().value ()));
    } else {
      todoItem.setColor (null);
    }
    todoItem.setDescription (request.getTodoItem ().getDescription ());
    todoItem.setResponse (request.getTodoItem ().getResponse ());
    todoItem.setDone (request.getTodoItem ().isDone ());
    todoItem.setOwner (owner);
    todoItem.setPriority (request.getTodoItem ().getPriority ());
    todoItem.setReceiver (receiver);
    todoItem.setSubject (request.getTodoItem ().getSubject ());
    todoItem.setSubmitDateTime (new DateTime (DateTimeZone.UTC).getMillis ());

    if (request.getTodoItem ().isHasDeadlineDateTime ()) {
      DateTime deadLineDateTime = new DateTime (request.getTodoItem ().getDeadlineDateYear (), request.getTodoItem ().getDeadlineDateMonth (),
          request.getTodoItem ().getDeadlineDateDay (), request.getTodoItem ().getDeadlineDateHour (), request.getTodoItem ()
              .getDeadlineDateMinute (), request.getTodoItem ().getDeadlineDateSecond (), request.getTodoItem ().getDeadlineDateMilliSecond (),
          DateTimeZone.UTC);
      todoItem.setDeadlineDateTime (deadLineDateTime.getMillis ());
    } else {
      todoItem.setDeadlineDateTime (null);
    }

    Long id = todoItemService.addTodoItem (todoItem);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddTodoItem", "TodoService", "0.0.1", "Added todoItem with id '" + id + "'", "",
        clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());

    AddTodoItemResponse response = new AddTodoItemResponse ();
    response.setTodoItemId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "UpdateTodoItemRequest")
  public @ResponsePayload
  UpdateTodoItemResponse handleUpdateTodoItemRequest (@RequestPayload UpdateTodoItemRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException, PersonNotFoundException,
      TodoItemNotFoundException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "UpdateTodoItem", "TodoService", "0.0.1", "Updating todoItem with id '" +
          request.getTodoItem ().getId () +
          "' ...", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person owner = personnelService.getPersonById (request.getTodoItem ().getOwnerId ());
    if (owner == null) {
      throw new PersonNotFoundException ();
    }
    Person receiver = personnelService.getPersonById (request.getTodoItem ().getReceiverId ());
    if (receiver == null) {
      throw new PersonNotFoundException ();
    }
    TodoItem todoItem = todoItemService.getTodoItemById (request.getTodoItem ().getId ());
    if (todoItem == null) {
      throw new TodoItemNotFoundException ();
    }
    if (request.getTodoItem ().getColor () != null) {
      todoItem.setColor (ColorType.valueOf (request.getTodoItem ().getColor ().value ()));
    } else {
      todoItem.setColor (null);
    }
    todoItem.setDescription (request.getTodoItem ().getDescription ());
    todoItem.setResponse (request.getTodoItem ().getResponse ());
    todoItem.setDone (request.getTodoItem ().isDone ());
    todoItem.setOwner (owner);
    todoItem.setPriority (request.getTodoItem ().getPriority ());
    todoItem.setReceiver (receiver);
    todoItem.setSubject (request.getTodoItem ().getSubject ());

    if (request.getTodoItem ().isHasDeadlineDateTime ()) {
      DateTime deadLineDateTime = new DateTime (request.getTodoItem ().getDeadlineDateYear (), request.getTodoItem ().getDeadlineDateMonth (),
          request.getTodoItem ().getDeadlineDateDay (), request.getTodoItem ().getDeadlineDateHour (), request.getTodoItem ()
              .getDeadlineDateMinute (), request.getTodoItem ().getDeadlineDateSecond (), request.getTodoItem ().getDeadlineDateMilliSecond (),
          DateTimeZone.UTC);
      todoItem.setDeadlineDateTime (deadLineDateTime.getMillis ());
    } else {
      todoItem.setDeadlineDateTime (null);
    }

    todoItemService.updateTodoItem (todoItem);
    UpdateTodoItemResponse response = new UpdateTodoItemResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "DeleteTodoItemRequest")
  public @ResponsePayload
  DeleteTodoItemResponse handleDeleteTodoItemRequest (@RequestPayload DeleteTodoItemRequest request) throws TodoItemNotFoundException,
      ClientInformationNeededException, UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "DeleteTodoItem", "TodoService", "0.0.1", "Deleting todoItem with id '" +
          request.getTodoItemId () +
          "' ...", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    TodoItem todoItem = todoItemService.getTodoItemById (request.getTodoItemId ());
    if (todoItem == null) {
      throw new TodoItemNotFoundException ();
    }
    todoItemService.deleteTodoItem (todoItem.getId ());
    DeleteTodoItemResponse response = new DeleteTodoItemResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetTodoItemByIdRequest")
  public @ResponsePayload
  GetTodoItemByIdResponse handleGetTodoItemByIdRequest (@RequestPayload GetTodoItemByIdRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException, TodoItemNotFoundException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetTodoItemById", "TodoService", "0.0.1", "Reading todoItem with id '" + request.getTodoItemId () + "'",
          "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }

    TodoItem todoItem = todoItemService.getTodoItemById (request.getTodoItemId ());
    if (todoItem == null) {
      throw new TodoItemNotFoundException ();
    }
    TodoItemType todoItemType = new TodoItemType ();
    if (todoItem.getColor () != null) {
      todoItemType.setColor (com.mftvanak.edusys.ws.messaging.schemas.types.ColorType.fromValue (todoItem.getColor ().toString ()));
    }
    todoItemType.setDescription (todoItem.getDescription ());
    todoItemType.setResponse (todoItem.getResponse ());
    todoItemType.setDone (todoItem.isDone ());
    todoItemType.setId (todoItem.getId ());
    todoItemType.setOwnerId (todoItem.getOwner ().getId ());
    todoItemType.setOwnerFullName (todoItem.getOwner ().getPersianName () + " " + todoItem.getOwner ().getPersianFamily ());
    todoItemType.setPriority (todoItem.getPriority ());
    todoItemType.setReceiverId (todoItem.getReceiver ().getId ());
    todoItemType.setReceiverFullName (todoItem.getReceiver ().getPersianName () + " " + todoItem.getReceiver ().getPersianFamily ());
    todoItemType.setSubject (todoItem.getSubject ());

    DateTime submitDateTime = new DateTime (todoItem.getSubmitDateTime (), DateTimeZone.UTC);
    todoItemType.setSubmitDateYear (submitDateTime.getYear ());
    todoItemType.setSubmitDateMonth (submitDateTime.getMonthOfYear ());
    todoItemType.setSubmitDateDay (submitDateTime.getDayOfMonth ());
    todoItemType.setSubmitDateHour (submitDateTime.getHourOfDay ());
    todoItemType.setSubmitDateMinute (submitDateTime.getMinuteOfHour ());
    todoItemType.setSubmitDateSecond (submitDateTime.getSecondOfMinute ());
    todoItemType.setSubmitDateMilliSecond (submitDateTime.getMillisOfSecond ());

    if (todoItem.getDeadlineDateTime () != null) {
      todoItemType.setHasDeadlineDateTime (true);
      DateTime deadlineDateTime = new DateTime (todoItem.getDeadlineDateTime (), DateTimeZone.UTC);
      todoItemType.setDeadlineDateYear (deadlineDateTime.getYear ());
      todoItemType.setDeadlineDateMonth (deadlineDateTime.getMonthOfYear ());
      todoItemType.setDeadlineDateDay (deadlineDateTime.getDayOfMonth ());
      todoItemType.setDeadlineDateHour (deadlineDateTime.getHourOfDay ());
      todoItemType.setDeadlineDateMinute (deadlineDateTime.getMinuteOfHour ());
      todoItemType.setDeadlineDateSecond (deadlineDateTime.getSecondOfMinute ());
      todoItemType.setDeadlineDateMilliSecond (deadlineDateTime.getMillisOfSecond ());
    } else {
      todoItemType.setHasDeadlineDateTime (false);
    }

    GetTodoItemByIdResponse response = new GetTodoItemByIdResponse ();
    response.setTodoItem (todoItemType);
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetTodoItemsRequest")
  public @ResponsePayload
  GetTodoItemsResponse handleGetTodoItemsRequest (@RequestPayload GetTodoItemsRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetTodoItems", "TodoService", "0.0.1", "Reading all todoItems", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetTodoItemsResponse response = new GetTodoItemsResponse ();
    for (TodoItem todoItem : todoItemService.getTodoItems ()) {
      TodoItemType todoItemType = new TodoItemType ();
      if (todoItem.getColor () != null) {
        todoItemType.setColor (com.mftvanak.edusys.ws.messaging.schemas.types.ColorType.fromValue (todoItem.getColor ().toString ()));
      }
      todoItemType.setDescription (todoItem.getDescription ());
      todoItemType.setResponse (todoItem.getResponse ());
      todoItemType.setDone (todoItem.isDone ());
      todoItemType.setId (todoItem.getId ());
      todoItemType.setOwnerId (todoItem.getOwner ().getId ());
      todoItemType.setOwnerFullName (todoItem.getOwner ().getPersianName () + " " + todoItem.getOwner ().getPersianFamily ());
      todoItemType.setPriority (todoItem.getPriority ());
      todoItemType.setReceiverId (todoItem.getReceiver ().getId ());
      todoItemType.setReceiverFullName (todoItem.getReceiver ().getPersianName () + " " + todoItem.getReceiver ().getPersianFamily ());
      todoItemType.setSubject (todoItem.getSubject ());

      DateTime submitDateTime = new DateTime (todoItem.getSubmitDateTime (), DateTimeZone.UTC);
      todoItemType.setSubmitDateYear (submitDateTime.getYear ());
      todoItemType.setSubmitDateMonth (submitDateTime.getMonthOfYear ());
      todoItemType.setSubmitDateDay (submitDateTime.getDayOfMonth ());
      todoItemType.setSubmitDateHour (submitDateTime.getHourOfDay ());
      todoItemType.setSubmitDateMinute (submitDateTime.getMinuteOfHour ());
      todoItemType.setSubmitDateSecond (submitDateTime.getSecondOfMinute ());
      todoItemType.setSubmitDateMilliSecond (submitDateTime.getMillisOfSecond ());

      if (todoItem.getDeadlineDateTime () != null) {
        todoItemType.setHasDeadlineDateTime (true);
        DateTime deadlineDateTime = new DateTime (todoItem.getDeadlineDateTime (), DateTimeZone.UTC);
        todoItemType.setDeadlineDateYear (deadlineDateTime.getYear ());
        todoItemType.setDeadlineDateMonth (deadlineDateTime.getMonthOfYear ());
        todoItemType.setDeadlineDateDay (deadlineDateTime.getDayOfMonth ());
        todoItemType.setDeadlineDateHour (deadlineDateTime.getHourOfDay ());
        todoItemType.setDeadlineDateMinute (deadlineDateTime.getMinuteOfHour ());
        todoItemType.setDeadlineDateSecond (deadlineDateTime.getSecondOfMinute ());
        todoItemType.setDeadlineDateMilliSecond (deadlineDateTime.getMillisOfSecond ());
      } else {
        todoItemType.setHasDeadlineDateTime (false);
      }

      response.getTodoItems ().add (todoItemType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetTodoItemsForPersonRequest")
  public @ResponsePayload
  GetTodoItemsForPersonResponse handleGetTodoItemsForPersonRequest (@RequestPayload GetTodoItemsForPersonRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetTodoItemsForPerson", "TodoService", "0.0.1",
          "Reading all todoItems for person with id '" + request.getPersonId () + "'", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetTodoItemsForPersonResponse response = new GetTodoItemsForPersonResponse ();
    for (TodoItem todoItem : todoItemService.getTodoItemsForPerson (request.getPersonId (), request.getCount ())) {
      TodoItemType todoItemType = new TodoItemType ();
      if (todoItem.getColor () != null) {
        todoItemType.setColor (com.mftvanak.edusys.ws.messaging.schemas.types.ColorType.fromValue (todoItem.getColor ().toString ()));
      }
      todoItemType.setDescription (todoItem.getDescription ());
      todoItemType.setResponse (todoItem.getResponse ());
      todoItemType.setDone (todoItem.isDone ());
      todoItemType.setId (todoItem.getId ());
      todoItemType.setOwnerId (todoItem.getOwner ().getId ());
      todoItemType.setOwnerFullName (todoItem.getOwner ().getPersianName () + " " + todoItem.getOwner ().getPersianFamily ());
      todoItemType.setPriority (todoItem.getPriority ());
      todoItemType.setReceiverId (todoItem.getReceiver ().getId ());
      todoItemType.setReceiverFullName (todoItem.getReceiver ().getPersianName () + " " + todoItem.getReceiver ().getPersianFamily ());
      todoItemType.setSubject (todoItem.getSubject ());

      DateTime submitDateTime = new DateTime (todoItem.getSubmitDateTime (), DateTimeZone.UTC);
      todoItemType.setSubmitDateYear (submitDateTime.getYear ());
      todoItemType.setSubmitDateMonth (submitDateTime.getMonthOfYear ());
      todoItemType.setSubmitDateDay (submitDateTime.getDayOfMonth ());
      todoItemType.setSubmitDateHour (submitDateTime.getHourOfDay ());
      todoItemType.setSubmitDateMinute (submitDateTime.getMinuteOfHour ());
      todoItemType.setSubmitDateSecond (submitDateTime.getSecondOfMinute ());
      todoItemType.setSubmitDateMilliSecond (submitDateTime.getMillisOfSecond ());

      if (todoItem.getDeadlineDateTime () != null) {
        todoItemType.setHasDeadlineDateTime (true);
        DateTime deadlineDateTime = new DateTime (todoItem.getDeadlineDateTime (), DateTimeZone.UTC);
        todoItemType.setDeadlineDateYear (deadlineDateTime.getYear ());
        todoItemType.setDeadlineDateMonth (deadlineDateTime.getMonthOfYear ());
        todoItemType.setDeadlineDateDay (deadlineDateTime.getDayOfMonth ());
        todoItemType.setDeadlineDateHour (deadlineDateTime.getHourOfDay ());
        todoItemType.setDeadlineDateMinute (deadlineDateTime.getMinuteOfHour ());
        todoItemType.setDeadlineDateSecond (deadlineDateTime.getSecondOfMinute ());
        todoItemType.setDeadlineDateMilliSecond (deadlineDateTime.getMillisOfSecond ());
      } else {
        todoItemType.setHasDeadlineDateTime (false);
      }

      response.getTodoItems ().add (todoItemType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetTodoItemsAssignedByPersonRequest")
  public @ResponsePayload
  GetTodoItemsAssignedByPersonResponse handleGetTodoItemsAssignedByPersonRequest (@RequestPayload GetTodoItemsAssignedByPersonRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetTodoItemsAssignedByPerson", "TodoService", "0.0.1",
          "Reading all todoItems assigned by a person with id '" + request.getPersonId () + "'", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetTodoItemsAssignedByPersonResponse response = new GetTodoItemsAssignedByPersonResponse ();
    for (TodoItem todoItem : todoItemService.getTodoItemsAssignedByPerson (request.getPersonId (), request.getCount ())) {
      TodoItemType todoItemType = new TodoItemType ();
      if (todoItem.getColor () != null) {
        todoItemType.setColor (com.mftvanak.edusys.ws.messaging.schemas.types.ColorType.fromValue (todoItem.getColor ().toString ()));
      }
      todoItemType.setDescription (todoItem.getDescription ());
      todoItemType.setResponse (todoItem.getResponse ());
      todoItemType.setDone (todoItem.isDone ());
      todoItemType.setId (todoItem.getId ());
      todoItemType.setOwnerId (todoItem.getOwner ().getId ());
      todoItemType.setOwnerFullName (todoItem.getOwner ().getPersianName () + " " + todoItem.getOwner ().getPersianFamily ());
      todoItemType.setPriority (todoItem.getPriority ());
      todoItemType.setReceiverId (todoItem.getReceiver ().getId ());
      todoItemType.setReceiverFullName (todoItem.getReceiver ().getPersianName () + " " + todoItem.getReceiver ().getPersianFamily ());
      todoItemType.setSubject (todoItem.getSubject ());

      DateTime submitDateTime = new DateTime (todoItem.getSubmitDateTime (), DateTimeZone.UTC);
      todoItemType.setSubmitDateYear (submitDateTime.getYear ());
      todoItemType.setSubmitDateMonth (submitDateTime.getMonthOfYear ());
      todoItemType.setSubmitDateDay (submitDateTime.getDayOfMonth ());
      todoItemType.setSubmitDateHour (submitDateTime.getHourOfDay ());
      todoItemType.setSubmitDateMinute (submitDateTime.getMinuteOfHour ());
      todoItemType.setSubmitDateSecond (submitDateTime.getSecondOfMinute ());
      todoItemType.setSubmitDateMilliSecond (submitDateTime.getMillisOfSecond ());

      if (todoItem.getDeadlineDateTime () != null) {
        todoItemType.setHasDeadlineDateTime (true);
        DateTime deadlineDateTime = new DateTime (todoItem.getDeadlineDateTime (), DateTimeZone.UTC);
        todoItemType.setDeadlineDateYear (deadlineDateTime.getYear ());
        todoItemType.setDeadlineDateMonth (deadlineDateTime.getMonthOfYear ());
        todoItemType.setDeadlineDateDay (deadlineDateTime.getDayOfMonth ());
        todoItemType.setDeadlineDateHour (deadlineDateTime.getHourOfDay ());
        todoItemType.setDeadlineDateMinute (deadlineDateTime.getMinuteOfHour ());
        todoItemType.setDeadlineDateSecond (deadlineDateTime.getSecondOfMinute ());
        todoItemType.setDeadlineDateMilliSecond (deadlineDateTime.getMillisOfSecond ());
      } else {
        todoItemType.setHasDeadlineDateTime (false);
      }

      response.getTodoItems ().add (todoItemType);
    }
    return response;
  }
}
