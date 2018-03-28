
1. Build
$ mvn package

2. Run
$ java -jar /target/hr-department-0.0.1.jar

3. Use Postman, SoapUI to access the HR Department Web Service at address http://localhost:8080
   Or use console...

# Create departments with ids  1, 2
curl -H "Content-Type:application/json" -X POST http://localhost:8080/department -d '{"name" : "Financial" }'
curl -H "Content-Type:application/json" -X POST http://localhost:8080/department -d '{"name" : "Logistics" }'

# Show all departments
curl -H "Content-Type:application/json" -X GET http://localhost:8080/departments

# Find department with id = 1
curl -H "Content-Type:application/json" -X GET http://localhost:8080/department/1

# Create employees with ids 3, 4, 5
curl -H "Content-Type:application/json" -X POST http://localhost:8080/employee -d '{"firstName" : "Alex", "lastName" : "Smith", "taxNumber" : "123", "gender" : "M", "birthDate" : "1967-02-11" }'
curl -H "Content-Type:application/json" -X POST http://localhost:8080/employee -d '{"firstName" : "Kate", "lastName" : "Jhonsons", "taxNumber" : "321", "gender" : "F", "birthDate" : "1999-06-12" }'
curl -H "Content-Type:application/json" -X POST http://localhost:8080/employee -d '{"firstName" : "Foo", "lastName" : "Bar", "taxNumber" : "312", "gender" : "M", "birthDate" : "1995-11-24" }'

# View all employees
curl -H "Content-Type:application/json" -X GET http://localhost:8080/emloyees

# Find employee with id = 3
curl -H "Content-Type:application/json" -X GET http://localhost:8080/emloyee/3

# Assing employees with ids 3,4 to department with id = 1
curl -H "Content-Type:application/json" -X PUT http://localhost:8080/employee/3/department/1
curl -H "Content-Type:application/json" -X PUT http://localhost:8080/employee/4/department/1

# Find all employees of department with id = 1
curl -H "Content-Type:application/json" -X GET http://localhost:8080/department/1/employees

# Update information about employee
curl -H "Content-Type:application/json" -X PUT http://localhost:8080/employee/3 -d '{"firstName" : "Alexander", "lastName" : "Smith", "taxNumber" : "123", "gender" : "M", "birthDate" : "1967-02-11" }'

# Update information about department
curl -H "Content-Type:application/json" -X PUT http://localhost:8080/department/1 -d '{"name" : "Tax & Accounting" }'

# Delete employee with id = 5
curl -H "Content-Type:application/json" -X DELETE http://localhost:8080/emloyees/5

# Delete department with id = 2
curl -H "Content-Type:application/json" -X DELETE http://localhost:8080/departments/2