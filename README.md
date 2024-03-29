## Membership with only Java (without Spring)

![memberService](https://github.com/MayHyeyeonKim/maycore/blob/main/images/classDiagram.png)

## Order & Discount Policy with only Java (without Spring)

![Order&DiscountService](https://github.com/MayHyeyeonKim/maycore/blob/main/images/Order&DiscountService.png)

## Documentation of encountered errors and the troubleshooting process
The client code OrderServiceImpl violates the Dependency Inversion Principle (DIP) by depending on not only the DiscountPolicy interface but also the concrete classes. To adhere to DIP, the dependency should be modified to rely solely on the interface.
![DIP&OCP](https://github.com/MayHyeyeonKim/maycore/blob/main/images/DIPOCP.png)
However, if there is no implementation available, how can the code be executed? In practice, attempting to run the code would result in a NullPointerException (NPE).
![NullPointerException](https://github.com/MayHyeyeonKim/maycore/blob/main/images/NullPointerException.png)

## How to address DIP (Dependency Inversion Principle) violation:
The appConfig object creates the memoryMemberRepository object and passes its reference to instantiate memberServiceImpl through the constructor. 
From the perspective of the client, memberServiceImpl, it seems as if the dependencies are being injected from the outside, leading to the term Dependency Injection (DI). <br>
<br>
The same approach applies to MemberServiceImpl and OrderServiceImpl as shown in the code below.
![AppConfig_DI](https://github.com/MayHyeyeonKim/maycore/blob/main/images/AppConfig_DI.png)

## Dependency Diagram
![Dependency Diagram](https://github.com/MayHyeyeonKim/maycore/blob/main/images/dependencyDiagram.png)

# Singleton Container
## Expected code for AppConfig@CGLIB
[Refer to Git commit 5d2a688](https://github.com/MayHyeyeonKim/maycore/commit/5d2a68858e49ff5cb87a1bb5da79801e6c6076b7) <br>
[Refer to Git commit 381ec40](https://github.com/MayHyeyeonKim/maycore/commit/381ec4004c4b415a71e98a382bf94f947ceb9f02)


```java
@Bean
public MemberRepository memberRepository() {
    if (springContainer.containsBean("memoryMemberRepository")) {
        // If memoryMemberRepository is already registered in the Spring container,
        // retrieve it from the container and return.
        return springContainer.getBean("memoryMemberRepository", MemberRepository.class);
    } else {
        // If memoryMemberRepository is not registered in the Spring container,
        // create a new MemoryMemberRepository using the existing logic,
        // register it in the Spring container, and then return.
        MemoryMemberRepository memoryMemberRepository = createMemoryMemberRepository();
        springContainer.registerSingleton("memoryMemberRepository", memoryMemberRepository);
        return memoryMemberRepository;
    }
}

```

# Component Scan Log
1. Identified candidate component class <br>
   ![Identified candidate component class](https://github.com/MayHyeyeonKim/maycore/blob/main/images/componentScan1.png)
2. Creating shared instance of singleton bean <br>
   ![Creating shared instance of singleton bean](https://github.com/MayHyeyeonKim/maycore/blob/main/images/componentScan2.png)
3. Autowiring by type <br>
   ![Autowiring by type](https://github.com/MayHyeyeonKim/maycore/blob/main/images/componentScan3.png)


