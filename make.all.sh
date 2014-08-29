#!/bin/bash

./check.server.sh
res=$(echo $?)
if [ $res -eq 1 ]; then
  exit 1
fi

./make.common.sh && ./make.domain.sh && ./make.facade.sh && ./make.ws.sh && ./make.ws.education.sh && ./make.ws.authentication.sh && ./make.ws.gheyas.sh && ./make.ws.membership.sh && ./make.ws.official.sh && ./make.ws.personnel.sh && ./make.ws.phonebook.sh && ./make.ws.portal.sh && ./make.ws.messaging.sh && ./make.engine.scheduler.sh && ./make.ui.web.staff
