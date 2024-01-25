# Spring-based Membership

![memberService](https://github.com/MayHyeyeonKim/maycore/blob/main/images/classDiagram.png)

# Spring-based Order & Discount Policy

![Order&DiscountService](https://github.com/MayHyeyeonKim/maycore/blob/main/images/Order&DiscountService.png)

# Documentation of encountered errors and the troubleshooting process
The client code OrderServiceImpl violates the Dependency Inversion Principle (DIP) by depending on not only the DiscountPolicy interface but also the concrete classes. To adhere to DIP, the dependency should be modified to rely solely on the interface.
![DIP&OCP](https://github.com/MayHyeyeonKim/maycore/blob/main/images/DIPOCP.png)
However, if there is no implementation available, how can the code be executed? In practice, attempting to run the code would result in a NullPointerException (NPE).
![NullPointerException](https://github.com/MayHyeyeonKim/maycore/blob/main/images/NullPointerException.png)

## How to address DIP (Dependency Inversion Principle) violation:
The appConfig object creates the memoryMemberRepository object and passes its reference to instantiate memberServiceImpl through the constructor. From the perspective of the client, memberServiceImpl, it seems as if the dependencies are being injected from the outside, leading to the term Dependency Injection (DI).
The same approach applies to OrderServiceImpl as shown in the code below.
![AppConfig_DI](https://github.com/MayHyeyeonKim/maycore/blob/main/images/AppConfig_DI.png)