# Spring Boot & React Full-Stack Application:

This project showcases the development of a full-stack web application using **Spring Boot** for the backend and **React** for the frontend. It covers a wide range of topics essential for building a production-grade application, from setting up the environment to deploying the final product on AWS Elastic Beanstalk.

## Project Highlights

- **Bootstrap Spring Boot Application:** Kickstart the backend using Spring Initializr.
- **React Frontend:** Build a responsive frontend using React and integrate it with the backend.
- **Backend API Development:** Create endpoints to handle requests, including retrieving and adding students.
- **Ant Design:** Implement UI components like tables, modals, and forms using Ant Design (Antd) for better user interaction.
- **Docker and PostgreSQL:** Set up and manage a PostgreSQL database using Docker, with custom migrations using Flyway.
- **Database Access Layer:** Use JdbcTemplate, result sets, and row mappers for efficient data access.
- **Form Handling:** Use Formik for form management, validation, and submission to the backend.
- **Error Handling:** Implement comprehensive error handling using promises, custom exceptions, and notifications.
- **Maven Build Process:** Customize builds using Maven profiles and lifecycle hooks to serve the frontend as static content.
- **Deployment to AWS:** Deploy the application on AWS Elastic Beanstalk with RDS database integration.

## Learning Outcomes

- How to set up a full-stack application using **Spring Boot** and **React**.
- Effective use of **Ant Design** for UI components.
- How to containerize applications with **Docker** and integrate them with **PostgreSQL**.
- Managing database migrations with **Flyway**.
- Comprehensive frontend-backend integration.
- Deployment on **AWS Elastic Beanstalk** with environment-specific configurations.

## Getting Started

To clone and run this application locally, follow these steps:
## Getting Started

To clone and run this application locally, follow these steps:

1. Clone the repository:
    ```cmd
    git clone https://github.com/Amiraelhoufy/spring-boot-react-fullstack.git
    ```

2. Navigate to the project directory:
    ```cmd
    cd spring-boot-react-fullstack
    ```

3. Start the backend server:
    ```cmd
    .\mvnw.cmd spring-boot:run
    ```

4. Start the frontend server:
    ```cmd
    cd src\js
    npm install
    npm start
    ```

5. Access the application in your browser at `http://localhost:3000`.


