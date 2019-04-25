# truststore-example
Example that connects to a site with a self signed certificate.

You should be able to start the application.
Go to:

http://localhost:8080/important

# Supply google account json

Get a service account to send logs from the application.
Set an environment variable to give it to the application.

    GOOGLE_APPLICATION_CREDENTIALS=gcp-logging-account.json

# Tamper with the keystore

You can always remove the truststore: badsslcom.jks

Then the application will not work anymore. You have to run:

    generate_keystore.sh
    
And the truststore will be created for you and it should work again.

# Reproducing the error

As the code is now. It will reproduce the error. It will send logs to gcp but
the important rest call (linked above) doesn't work. You should see a PKIX 
exception in the logs. 

Comment out the stackdriver line in logback.xml.

    <!--<appender-ref ref="STACKDRIVER" />-->

And logging stops working, but the call to badssl.com will now work.