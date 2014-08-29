#!/bin/sh

./check.server.sh
res=$(echo $?)
if [ $res -eq 1 ]; then
  exit 1
fi

./publish.ws.authentication.sh && ./publish.ws.education.sh && ./publish.ws.gheyas.sh && ./publish.ws.membership.sh && ./publish.ws.official.sh && ./publish.ws.personnel.sh && ./publish.ws.phonebook.sh && ./publish.ws.portal.sh && ./publish.ws.messaging.sh && ./publish.ui.web.staff.sh
