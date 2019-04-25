#!/bin/bash

keytool -importcert -keystore badsslcom.jks -storepass changeit -file "badsslcom.crt" -alias badsslcom
