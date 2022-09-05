
### Guides

The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### DDD架構
* User Interface (Presentation) 負責向使用者顯示資訊和解釋使用者的指令。使用者可能是人也有可能是另一個系統。
* Application 定義軟體要完成的任務(使用案例)，並指揮 Domain 來實現業務邏輯的計算。
* Domain 負責保管業務概念、業務狀態以及業務規則。本程式軟體的核心。
* Infrastructure 為上面各層提供技術能力：為 Application 傳遞訊息、為 Domain 提供持久化機制、為 User Interface 處理畫面等等。
