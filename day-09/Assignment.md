# Assignment on JPA

Use a copy of the **`miniproject`** for this assignment. When run, the application displays the following menu:

```
==== Main Menu ====
0. Exit
1. List all customers
2. Add a new customer
3. Search customer by id
4. Search customer by email
5. Search customer by phone
6. Search customers by city
```

- Choices 1 to 3 have already been implemented.
- Write the solution for choices 4 to 6.
- Implement the `CustomerDao` using **JPA**.
- Update the `java/main/resources/dao-config.properties` to refer to your implementation.
- Use `H2` database (use the version 1.4.197 to run the server).
- Create the `customers` table to match the `Customer` entity class.
- Make sure to handle all exceptions appropriately and ensure that the application does not break.
