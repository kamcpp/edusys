<?php

$client = new SoapClient("http://auth.ws.edusys.mftvanak.tk:8080/com.mftvanak.edusys.ws.auth-0.0.1-SNAPSHOT/auth.wsdl");

    $ap_param = array(
                    'Username'     =>    'admin' ,
                     'Password'     =>    '12345',
                      'ClientTime'     =>    '0',
                       'Email'     =>    'null',

                    );


        $error = 0;
        try {
        //  $info = $client->__call("Authentication", array($ap_param));
        //  print $info->Token->TokenValue.'<br>';
      //    print $info->Token->Active.'<br>';



                     $ap_param2 = array(
                    'Token'     =>    '84b555f7-0583-4a41-8977-9f472322b7e0-eba8d7ec-43d8-4365-a2b5-98044bc67ce8',


                    );

           $info = $client->__call("ValidateToken", array($ap_param2));
            print $info->Result;
        } catch (SoapFault $fault) {
            $error = 1;
           echo $fault;
          }

?>