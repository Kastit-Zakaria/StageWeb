\# 🏕️ StageWeb – Holiday Camp Management



StageWeb is a web application to manage \*\*holiday camps for children\*\*: camps, children and registrations, with business rules on age, dates and duplicate registrations.



Built with \*\*Spring Boot\*\* following the \*\*MVC\*\* architecture, with \*\*Spring Data JPA / Hibernate\*\* and \*\*Thymeleaf\*\* server-side views.



!\[Java](https://img.shields.io/badge/Java-21-007396?logo=openjdk\&logoColor=white)

!\[Spring Boot](https://img.shields.io/badge/Spring%20Boot-4-6DB33F?logo=springboot\&logoColor=white)

!\[Hibernate](https://img.shields.io/badge/JPA%20%2F%20Hibernate-59666C?logo=hibernate\&logoColor=white)

!\[Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf\&logoColor=white)

!\[MySQL](https://img.shields.io/badge/MySQL%20%2F%20MariaDB-4479A1?logo=mysql\&logoColor=white)

!\[Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?logo=bootstrap\&logoColor=white)

!\[Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven\&logoColor=white)



\---



\## 📸 Screenshots



| Camps | Children | Registrations |

|-------|----------|---------------|

| !\[Camps](docs/screenshots/stages-list.png) | !\[Children](docs/screenshots/children-list.png) | !\[Registrations](docs/screenshots/registrations-list.png) |



| New camp | New child | New registration |

|----------|-----------|------------------|

| !\[New camp](docs/screenshots/stage-add-form.png) | !\[New child](docs/screenshots/child-add-form.png) | !\[New registration](docs/screenshots/registration-add-form.png) |



\### ✅ Business rules in action



| Child too young | Child too old | Duplicate registration refused |

|-----------------|---------------|--------------------------------|

| !\[Too young](docs/screenshots/registration-child-too-young.png) | !\[Too old](docs/screenshots/registration-child-too-old.png) | !\[Duplicate](docs/screenshots/registration-duplicate-refused.png) |



| Search camps | Search children | Form validation |

|--------------|-----------------|-----------------|

| !\[Search camps](docs/screenshots/stages-search.png) | !\[Search children](docs/screenshots/children-search.png) | !\[Validation](docs/screenshots/child-validation-errors.png) |



More screenshots are available in \[`docs/screenshots/`](docs/screenshots/).



\---



\## ✨ Features



\*\*Camps\*\*

\- Create, list, edit and delete camps (name, dates, minimum and maximum age, price)

\- Search camps by name



\*\*Children\*\*

\- Create, list, edit and delete children (last name, first name, date of birth, gender)

\- Search children by name



\*\*Registrations\*\*

\- Register a child to a camp and mark the registration as paid or unpaid

\- Edit and delete registrations



\*\*Business rules\*\*

\- A child can only be registered if their \*\*age matches the camp's age range\*\* (checked to the exact day)

\- A child \*\*cannot be registered twice\*\* to the same camp (unique constraint on child + camp)

\- A camp's age range must be between \*\*3 and 18 years\*\*, with minimum age ≤ maximum age

\- A camp's end date must be \*\*after its start date\*\*

\- Form validation with \*\*Bean Validation\*\* and error messages displayed next to the fields; the user's input is kept when the form is rejected



\---



\## 🛠️ Technical choices



\- \*\*MVC architecture\*\*: controllers, JPA entities, Spring Data repositories and Thymeleaf views

\- \*\*JPA entities and relationships\*\*: `Enfant` (child), `Stage` (camp) and `Inscription` (registration) linked by `@ManyToOne` associations

\- \*\*Spring Data JPA\*\* repositories with derived queries for search

\- \*\*Bean Validation\*\* (`@NotBlank`, `@Min`, `@Max`) combined with business checks in the controllers

\- \*\*Unique constraints\*\* in the database to guarantee data integrity



\---



\## 🚀 Installation



\### Requirements

\- \*\*JDK 21\*\* or newer

\- \*\*Maven\*\* (or an IDE with Maven support: NetBeans, IntelliJ IDEA, Eclipse)

\- \*\*MySQL / MariaDB\*\* (for example with XAMPP)



\### Steps



1\. \*\*Clone the project\*\*

&#x20;  ```bash

&#x20;  git clone https://github.com/Kastit-Zakaria/StageWeb.git

&#x20;  cd StageWeb

&#x20;  ```



2\. \*\*Create the database\*\*: in phpMyAdmin, create a database named `stage` (collation `utf8mb4\_general\_ci`), then import `database/stage\_demo.sql`.



3\. \*\*Check the configuration\*\* in `src/main/resources/application.properties` (by default: user `root`, no password, port `8081`).



4\. \*\*Run the application\*\* from your IDE, or with:

&#x20;  ```bash

&#x20;  mvn spring-boot:run

&#x20;  ```



5\. \*\*Open the application\*\*:

&#x20;  - Camps: \[http://localhost:8081/stages](http://localhost:8081/stages)

&#x20;  - Children: \[http://localhost:8081/enfants](http://localhost:8081/enfants)

&#x20;  - Registrations: \[http://localhost:8081/inscriptions](http://localhost:8081/inscriptions)



The demo database contains 6 camps, 10 children and 12 registrations.



\---



\## 📁 Project structure



```

src/main/java/com/example/stageWeb/

├── controller/   # Request handling and business checks

├── entity/       # JPA entities (Enfant, Stage, Inscription)

└── repository/   # Spring Data JPA repositories

src/main/resources/

├── templates/    # Thymeleaf views

└── application.properties

database/         # SQL export with demo data

docs/screenshots/ # Screenshots

```



\---



\## 🗺️ Known limitations / next steps



This is a school project. An end-to-end test pass identified improvements I plan to work on: friendlier error pages when a record is still referenced (deleting a child or a camp with registrations), age checks when editing an existing registration, delete confirmations and length limits on text fields.



\---



\## 👤 Author



\*\*Zakaria Kastit\*\* – Application Development student, EAFC Brussels

\[LinkedIn](https://www.linkedin.com/in/zakaria-kastit-90363a243) · \[GitHub](https://github.com/Kastit-Zakaria)

