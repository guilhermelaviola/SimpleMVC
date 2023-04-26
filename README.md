# SimpleMVC

## What is MVC?
MVC (Model-View-Controller) is a pattern in software design commonly used to implement user interfaces, data, and controlling logic. It emphasizes a separation between the software's business logic and display. This "separation of concerns" provides for a better division of labor and improved maintenance.
![image](https://user-images.githubusercontent.com/31170255/234636785-8b54081b-3037-4fc8-ba15-2474632e261a.png)

## Use case:
- Imagine a user registering application;
- The user enter its info + hobbies and clicks to insert, alter, remove or list the items (hobbies). In this case he/she is accessing the application through the **View**;
- The **Controller** receives this update from the **View** and then notifies the **Model** to make the change on the database;
- Then the **Model** updates the application to reflect the change made, in this case, adding the new hobby to the user row on database, and obviously display it in the **View**.

Here is what the application screen looks like:

![image](https://user-images.githubusercontent.com/31170255/234435017-0729f1a3-7c77-47ab-8bce-750f8f5c2556.png)
