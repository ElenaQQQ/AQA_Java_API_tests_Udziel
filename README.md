# AQA_Java_API_test_Udziel
API testing of Udziel project - charity cashback platform.
Stack: Java Selenium, Maven, TestNG, REST API, Rest Assured, Lombok, Allure

Testing functionality:
- User registration
- User account - getting info, changing data, user deleting 
- Admin access - getting users list

Test types:
- positive and negative
- boundary value analysis
- end-to-end

Using:
- Faker to generate test data
- Credentials at config.file, added to .gitignore
- Annotations @BeforeTest, @BeforeMethod, @AfterTest, @AfterMethod
- Methods POST, GET, PUT, PATCH, DELETE
- User objects as a method's parameter, as a request body
- Data provider
- Page object model

- Classes:
  
  config/config - values for setting test environment
         /Credentials - user and admin credentials (added to .gitignore)
  entities/ - User object for different purposes
  tests/ - Tests according to functionality
       /BasePageTest - BeforeTest and fields for all test classes
--------------------------------------------------------------------------------------------------------- 
Test cases https://docs.google.com/spreadsheets/d/1lgdtxuimH7yPoQllVRT83CEFomYyfdceHGIMu7KvRfE/edit#gid=0

