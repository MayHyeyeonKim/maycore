# Spring-based Membership

![memberService](https://github.com/MayHyeyeonKim/maycore/blob/main/classDiagram.png)

# Spring-based Order & Discount Policy

![Order&DiscountService](https://github.com/MayHyeyeonKim/maycore/blob/main/Order&DiscountService.png)

# Spring-based Order & Discount Policy
The client code OrderServiceImpl violates the Dependency Inversion Principle (DIP) by depending on not only the DiscountPolicy interface but also the concrete class. To adhere to DIP, the dependency should be modified to rely solely on the interface.
![DIP&OCP](https://github.com/MayHyeyeonKim/maycore/blob/main/DIPOCP.png)
However, if there is no implementation available, how can the code be executed? In practice, attempting to run the code would result in a NullPointerException (NPE).
![NullPointerException](https://github.com/MayHyeyeonKim/maycore/blob/main/NullPointerException.png)


