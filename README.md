# Programming Assignment 7 In the respective order, these classes are able to:
BaseResponse Class:
	- has responseCode and responseString variables inherited by StudentResponseString and StudentResponseObject subclasses
	- Used by Controller class to indicate success or failure of method.
StudentResponseString Class:
	- Used by Controller when getting Student as a string
	- content and listContent String variables contain one or many students in their toString() form
StudentResponseObject Class:
	- Used by Controller when getting Student as an object
	- content and listContent String variables contain one or many students as a Student Object. listContent is an ArrayList of Student objects.
Controller Class:
	- The utmost layer of the layered architecture web server
	- Responsible for checking validity of inputs for the methods. (Methods return IResponse with responseCode and responseString
	  representative of the outcome)
	- Methods include getStudent(),getAllStudent(),removeStudent(),addStudent(),updateStudent(),getResponse(),setResponse(),setService(), and getService()
Service Class:
	- Receives requests from the Controller class and relays it to the Database class. Will then receive a message from the Database class and relay
	  it to the Controller Class.
	- The middle layer of the layered architecture web server
	- In addition to the methods in the Controller class relating to Students, may instantiate Database Objects.
	- Contains the studList List<Student> that loads the information from the Database.
Database Class:
	- The bottom later of the layered architecture web server and contains the data of the Student Objects.
	- Will save changed information to the Database file whenever changes are made.
	- Will keep track of the time at which changes are made so that the Database file does not have to be reloaded after each method.
## Author

* **Suk Chan Lee**
- [cs11wme](mailto:scl002@ucsd.edu)


## Acknowledgments

* A thank you to freeCodeCamp and Professor James Gappy who taught me Java.
Gratitudes to Professor Zaitsev who is currently teaching me Java as well.