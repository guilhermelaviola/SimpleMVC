# SimpleMVC

## What is MVC?
MVC (Model-View-Controller) is a pattern in software design commonly used to implement user interfaces, data, and controlling logic. It emphasizes a separation between the software's business logic and display. This "separation of concerns" provides for a better division of labor and improved maintenance.
file:///C:/Users/guilh/Desktop/GitHub.jpg

## Use case:
- Imagine an e-commerce application;
- The user logs in and clicks to add an item to cart. In this case he/she is accessing the application through the **View**;
- The **Controller** receives this update from the **View** and then notifies the **Model** to add the item to cart;
- Then the **Model** updates the application to reflect the change made, in this case, adding the new item to cart, and obviously display it in the **View**.
Here is how the application screen looks like:

![image](https://user-images.githubusercontent.com/31170255/234435017-0729f1a3-7c77-47ab-8bce-750f8f5c2556.png)
