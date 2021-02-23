# money-lion
to run type <b>mvn</b>

list of Features Names to test
-
- features_1
- features_2
- features_3
- features_4
- features_5
- features_6

list of User Email to test
-
- user1@yahoo.com
- user2@yahoo.com
- user3@yahoo.com
- user4@yahoo.com
- user5@yahoo.com
- user6@yahoo.com

List of user + features
-
- user1@yahoo.com [features_2,features_3,features_4]
- user2@yahoo.com [features_3,features_4,features_5]
- user3@yahoo.com [features_2]
- user4@yahoo.com [features_2]

Example of endpoints
-
- GET http://localhost:8080/feature?email=user1@yahoo.com&featureName=features_5
- POST http://localhost:8080/feature {
                                   	"featureName" :"features_7",
                                   	"email" : "user1@yahoo.com",
                                   	"enable" : true
                                   }



