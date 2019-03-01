### Google Analytics

Get started guide:

https://developers.google.com/analytics/devguides/reporting/core/v3/quickstart/service-java

Create service acccount, download JSON. This contains clientID you will need to send requests. Get tracking ID from main Analytics page.

Make Google Analytics account with dummy website URL (any will do). Then go Admin -> User Management -> Add your key name to the project. So API account is authorized.
e.g. add xyz@@stable-ring-11111.iam.gserviceaccount.com

Then can send events/page views. Can then create custom reports, filter by event action/label etc.

#Measurement Protocol:

https://developers.google.com/analytics/devguides/collection/protocol/v1/devguide
https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters

#Java sample:

https://github.com/GoogleCloudPlatform/java-docs-samples/blob/master/flexible/analytics/src/main/java/com/example/analytics/AnalyticsServlet.java