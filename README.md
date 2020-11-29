# cookiefactory-20-21-team-v
cookiefactory-20-21-team-v created by GitHub Classroom

## User stories
### User Story #1 ( MUST Sizing L ) ✔️
**As** a customer, **I want** to order the basic recipe **in order to** buy the cookies.

Acceptance criteria

I am a customer, and I want to order the recipe.
- If I don’t have an account, I can directly make order.
- If I have an account, I will log in first and then make order.

Acceptance test
- Initialisation: I am a customer.
- Action: I don't have an account, and I order the recipe.
- Expected result: My order is confirmed.

#### feature: 
#### Scenario:

### User Story #2 ( MUST Sizing M ) ✔️
**As** a customer non-registered, **I want** to register an account **in order to** save my information. 

Acceptance criteria

I am a customer, and I want to register an account.
- If I don't have an account, I register an account.

Acceptance test
- Initialisation: I am a customer non-registered and I want to have my own account.
- Action: I register an account.
- Expected result: I successfully register an account.

### User Story #3 ( MUST Sizing S ) :heavy_check_mark:
**As** a customer registered, **I want** to join “Loyalty program” **in order to** profit further discounts.

Acceptance criteria

I am a customer, I want to join the “Loyalty program”.
- If I have an account without “Loyalty program”, I can join the “Loyalty program”.
- If I have joined the “Loyalty program”, I can’t join it again.

Acceptance test
- Initialisation: I am a customer and I have registered an account.
- Action: I join the “Loyalty program”.
- Expected result: I successfully joined.

#### The name of *feature* Cucumber file: Customer.feature ( ../test/resources/Customer.feature )
#### The name of scenario: Laura join the "Loyalty program"

### User Story #4 ( MUST Sizing S ) :heavy_check_mark:
**As** a store manager, **I want** to change the opening hours **in order to** match customer flow.

Acceptance criteria

I am a store manager, I want to change the opening hours.
- If the customer flow is very low for a certain period of time, I change the opening hours.
- If there are special situations, I will change the opening hours according to the situations.

Acceptance test
- Initialisation: I am a store manager and I enter the store setting.
- Action: I change the opening hours.
- Expected result: The opening hours changed.

#### The name of *feature* Cucumber file: StoreManager.feature ( ../test/resources/StoreManager.feature )
#### The name of scenario: Paule changes the opening hours

### User Story #5 ( MUST Sizing M ) 
**As** a customer, **I want** to pick my order **in order to** get my cookies.

Acceptance criteria

I am a customer, I want to pick my order.
- If it has not reached the time of the order I selected, I can't get my order.
- If it reached the time of the order I selected, I can get my order.
- If the store is closed, I can't get my order.

Acceptance test
- Initialisation: I am a customer and I enter the store.
- Action: It reached the time of the order I selected .
- Expected result: I get my order.

### User Story #6 ( MUST Sizing S ) 
**As** a customer, **I want** to pay my order by credit card **in order to** make order successfully.

Acceptance criteria

I am a customer, I want to pay my order by credit card.
- If I pay my order by credit card, I make my order successfully.

Acceptance test
- Initialisation: I am a customer and I choose my cookies.
- Action: I pay my order by credit card.
- Expected result: I make my order successfully.

### User Story #7 ( MUST Sizing S ) :heavy_check_mark:
**As** a customer who joined “Loyalty program”, **I want** to make order with 10% discount **in order to** pay less.

Acceptance criteria

I am a customer who joined “Loyalty program”, I hope I can order with discount.
- If I have ordered 30 cookies before, I can use the 10% discount.
- If I have not ordered 30 cookies before, I can't use the 10% discount.

Acceptance test
- Initialisation: I am a customer and I have ordered 30 cookies before.
- Action: I use the 10% discount in this order.
- Expected result: Le prix réduit de 10%.

#### The name of *feature* Cucumber file: Customer.feature ( ../test/resources/Customer.feature )
#### The name of scenario: Peter use discount 10% after an order of 30 cookies

### User Story #8 ( MUST Sizing M ) :heavy_check_mark:
**As** a brand manager. **I want** to add new basic recipes to the list every month **in order to** draw more customers. 

Acceptance criteria

I am a brand manager.
- If we develop a new menu, I add the new basic recipes to the list.

Acceptance test
- Initialization: I am a brand manager.
- Action: I change the basic recipe list by adding the new basic recipe.
- Expected result: The new basic recipe is successfully added.

#### The name of *feature* Cucumber file: BrandManager.feature ( ../test/resources/BrandManager.feature )
#### The name of scenario: Jason wants to add a new recipe

### User Story #9 ( MUST Sizing S ) :heavy_check_mark:
**As** a store manager. **I want** to change the tax **in order to** obey the law or get customers

Acceptance criteria

I am a store manager, I want to change the tax.
- If the store location has changed the tax, I change the tax of my store.

Acceptance test
- Initialization: I am a store manager, the store location has changed the tax.
- Action: I change the store tax.
- Expected result: The store tax is successfully changed.

#### The name of *feature* Cucumber file: StoreManager.feature ( ../test/resources/StoreManager.feature )
#### The name of scenario: Paule changes the tax

### User Story #10 ( MUST Sizing M ) :heavy_check_mark:
**As** a brand manager. **I want** to delete basic recipes not ordered by many people every month **in order to** reduce loss.

Acceptance criteria

I am a brand manager.
- If a basic recipe is not ordered by many people, I delete it from the list.

Acceptance test
- Initialization: I am a brand manager.
- Action: I change the basic recipe list by deleting a basic recipe.
- Expected result: The basic recipe is successfully deleted.

### User Story #11 ( MUST Sizing M ) 
**As** a customer, **I want** the store to send the order to my home through the service MarcelEat **in order to** save my time.

Acceptance criteria

I am a customer.
- If I don't have time to pick my order, I decided to use MarcelEat to send the order to my home.

Acceptance test
- Initialization: I want to use MarcelEat to deliver my orders due to I don't have enough time.
- Action: I create my order and I choose MarcelEat to send my order.
- Expected result: My order is delivered by MarcelEat to my home.

### User Story #12 ( MUST Sizing S ) :heavy_check_mark:
**As** a customer, **I want** to choose another store when the original store has a technical problem **in order to** still buy my cookies. 

Acceptance criteria

I am a customer, I want to choose another store when the original store has a technical problem.
- If the store which I have chosen has a technical problem, the store returns to the list of nearby stores for me to change the selected store.

Acceptance test
- Initialization: I am a client , the store I’ve chosen has a technical problem.
- Action: The store returns to the list of nearby stores for me and I choose one of them.
- Expected result: I changed the store.

### User Story #13 ( MUST Sizing L ) 
**As** a store manager, **I want** the store can automatically calculate the most popular recipe over the last 30 days **in order to** make it as the BestOf cookie.

Acceptance criteria

I am a store manager. I want the store can automatically calculate the most popular recipe over the last 30 days.
- If a recipe is the most popular recipe over the last 30 days, I make it as the BestOf cookie.

Acceptance test
- Initialisation: I am a store manager.
- Action: The store automatically calculate the most popular recipe over the last 30 days
- Expected result: The recipe is made as the BestOf cookie.

### User Story #14 ( MUST Sizing S ) 
**As** a customer, **I want** to order the BestOf cookie **in order to** pay 10% less.

Acceptance criteria

I am a customer, I want to order the BestOf cookie.
- If I order the BestOf cookie, the price is reduced 10%.

Acceptance test
- Initialisation: I am a customer.
- Action: I order the BestOf cookie.
- Expected result: The price is reduced 10%.

### User Story #15 ( MUST Sizing M ) 
**As** a customer, **I want** to order the personnel recipe created by myself **in order to** better suit my taste.

Acceptance criteria

I am a customer, and I want to order the personnel recipe.
- If the basic recipe doesn’t suit my taste, I create my own recipe and order it.

Acceptance test
- Initialisation: I am a customer.
- Action: I create my own recipe and order it.
- Expected result: I successfully ordered.

### User Story #16 ( MUST Sizing M ) 
**As** a customer, **I want** to change the basic recipe as the personnel recipe **in order to** better suit my taste.

Acceptance criteria

I am a customer, and I want to change the basic recipe as the personnel recipe.
- If the basic recipe doesn’t suit my taste, I change the basic recipe by adding or removing ingredients, or even by adding double or triple doses, then I order it.

Acceptance test
- Initialisation: I am a customer.
- Action: I change the basic recipe by adding ingredients and order it.
- Expected result: I successfully ordered.

### User Story #17 ( MUST Sizing S ) 
**As** a customer, **I want** to change the way from picking up at the store to home delivery **in order to** get my order.

Acceptance criteria

I am a customer.
- If I’ve already chosen to pick the order but suddenly can’t go to the store, I choose MarcelEat to deliver the order 

Acceptance test
- Initialization: I want to change my way of delivery.
- Action: I change the way from picking up to home delivery.
- Expected result: My order is delivered by MarcelEat to my home.


### User Story #18 ( MUST Sizing M ) 
**As** a store manager, I receive a request that the customer want to change the way from picking up to a delivery , **I want** to contact the MarcelEat and increase 50% price of delivery fee **in order to** complete the order and get a reasonable profit.

Acceptance criteria

I am a store manager.
- If I receive a request that the customer want to change the way from picking up to a delivery, I will contact the MarcelEat and increase 50% price of delivery fee.

Acceptance test
- Initialization: I receive a request that the customer want to change the way from picking up to a delivery.
- Action: I contact the MarcelEat and increase 50% price of delivery fee.
- Expected result: The delivery fee is increase 50% and the order is delived by the MarcelEat.

### User Story #19 ( MUST Sizing M ) :heavy_check_mark:
**As** a store manager, **I want** to check if my store can accept the orders **in order to** make sure the store have enough ingredients to make the order.

Acceptance criteria

I am a store manager, I want to check if my store can accept the orders.
- If the store recive the order, I check if the store have enough ingredients to make the order.

Acceptance test
- Initialization: I received an order
- Action: I check the store have enough ingredients to make the order.
- Expected result: The order is confirmed as achievable.

### User Story #20 ( MUST Sizing S ) :heavy_check_mark:
**As** a store manager, **I want** to increase the price of the personnel recipe by 25% **in order to** get a reasonable profit.

Acceptance criteria

I am a store manager.
- If the customer create his personnel recipe, I inrease the price by 25%.

Acceptance test
- Initialization: The customer create his personnel recipe.
- Action: I inrease the price by 25%.
- Expected result: The price have been increased by 25%.

#### The name of *feature* Cucumber file: StoreManager.feature ( ../test/resources/StoreManager.feature )
#### The name of scenario: Laura ordered her personnel recipe, the price is increased 25%

### User Story #21 ( MUST Sizing M )
**As** a customer, **I want** to choose another store for my cookies when there are many orders chosen at the same time **in order to** get my order in time. 

Acceptance criteria

I am a customer, I want to choose another store when the store I’ve chosen is too busy.
- If there are many orders chosen at the same time, the store returns to the list of nearby stores for me to change the selected store.

Acceptance test
- Initialization: I am a customer, the store I’ve chosen is too busy that I should wait for a period of time.
- Action: I cancel my original choice of store and choose another one.
- Expected result: my order was placed in the other store and I get to receive my cookies in time.

### User Story #22 ( MUST Sizing M )
**As** a customer, **I want** to choose another store for my cookies when the store that I’ve chosen lacks ingredients **in order to** make sure i can get my order.

Acceptance criteria

I am a customer, I want to choose another store for my cookies when the store that I’ve chosen lacks ingredients.
- If the store that I’ve chosen lacks ingredients, the store returns to the list of nearby stores for me to change the selected store.

Acceptance test
- Initialization: I am a customer , the store i’ve chosen lacks ingredients for my order.
- Action: I cancel my original choice of store and choose another one.
- Expected result: my order was placed in the other store and I get to receive my cookies in time.

### User Story #23 ( MUST Sizing M ) :heavy_check_mark:
**As** a store manager, **I want** to manage ingredients **in order to**  add lack ingredients in time.

Acceptance criteria
I am a store manager, I want to manage ingredients.
- If the store lack a kind of ingredients, I add it in time 

Acceptance test
- Initialization:I am a store manager, the store lack a kind of ingredients.
- Action: I add the lack ingredient.
- Expected result: The ingredient is added.
