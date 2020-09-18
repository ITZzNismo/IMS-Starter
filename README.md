Coverage: 72.8%
## Inventory Management System (IMS)

This project manages customers, items and orders within an IMS database. This allows the user to create, read, update or delete anything in the customers, items and orders tables.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. Download/clone the IMS-Starter into your local machine.
2. Open up your chosen IDE.
3. Import the project from your files.
4. Open the Runner class and press run.
5. Follow the instructions in the console.
6. Open and edit other classes for testing and development purposes.

### Prerequisites

You will need:
1. MySQL.
2. Java.
3. Eclipse (Recommended but can be any IDE).

## Installing

<ins>How to install MySQL</ins>
1. Follow this link: https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/ and make sure the version is set to 5.7.
2. Click on the install button which is relevant to your system.
3. Follow the on-screen instructions.
4. If you are using Windows 10, follow this link for a helpful tutorial video explaining the installation procedure and the solutions to any problems that may arise: https://www.youtube.com/watch?v=P99dA0yGY8g&t=1475s
5. Once MySQL is fully installed and working type (without quotation marks) "create database example;" -> "use example"; -> "create table example_table(example_column int(5));" -> "insert into example_table(example_column) values(100);" -> "select * from example_table;". This will show you a completed table as a basic example of how SQL works

<ins>How to install Java</ins>
1. Follow this link: https://www.java.com/en/download/manual.jsp
2. Click the download link associatd to your system.
3. Follow the on-screen instructions.
4. Make sure to select Java 8.

<ins>How to install Eclipse</ins>
1. Follow this link: https://www.eclipse.org/downloads/packages/installer
2. Follow the on-screen instructions to install the latest version of Eclipse.
3. Once downloaded, go to File -> New -> Java Project -> Give it a name -> Click Finish. -> Right-click on the project -> New -> Give it a name -> tick the box that states: public static void main(String[] args) -> Click finish -> Within the main method type: System.out.println("Hello World"); -> Save the class by pressing ctrl + s -> Click run or press ctrl + f11. Hello World will print in the console, which shows you a basic example that shows that Java and Eclipse (or your preferred IDE) is working.

## Running the tests

1. Open either the DAOTest, ControllerTest or Test for Customers, Items or Orders in the Test package.
2. Press run or ctrl + f11 to test the corresponding file.

### Unit Tests 

These tests will test their corresponding main file e.g. ItemsControllerTest will test ItemsController in main.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins] (https://github.com/christophperrins)
* **Simon Powelll** - *Further development* - [Simon Powell] (https://github.com/spowell24)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thank you Jordan Harrison (https://github.com/JHarry444) for your support and initialise help in this project
