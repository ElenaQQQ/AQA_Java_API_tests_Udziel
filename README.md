# AQA_Java_API_test_Udziel
API testing of Udziel project - charity cashback platform.
Stack: REST API, Rest Assured, Lombok, 

Testing functionality:
- User registration
- User account - getting info, changing data
- Admin access - getting users list

Test types:
- positive and negative
- boundary value analysis
- end-to-end

Using:
- Faker to generate test data, test data file
- Credentials at Config.file, added to .gitignore
- Annotations @BeforeTest, @BeforeMethod, @AfterTest, @AfterMethod
- Methods POST, GET, PUT, PATCH, DELETE
- User objects as a method's parameter, as a request body

--------------------------------------------------------------------------------------------------------- 
Test cases https://docs.google.com/spreadsheets/d/1lgdtxuimH7yPoQllVRT83CEFomYyfdceHGIMu7KvRfE/edit#gid=0

