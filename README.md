# Spotlight App

**Spotlight** is a dynamic web application designed to showcase and manage celebrity profiles. It allows users to view celebrity details, search by profession or name, and explore trending and top-rated celebrities. The app features a robust backend built with **Spring Boot**, integrated with **PostgreSQL** for data management, and **Keycloak** for authentication. The frontend is developed using **Next.js** and **Tailwind CSS**, providing a sleek, user-friendly experience.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [License](#license)

## Overview
Spotlight is a celebrity management and discovery platform that showcases:
- Celebrity profiles (basic info, career details, and more).
- Trending and top-rated celebrities.
- Search functionality by name, profession, or other filters.

The backend API is built with **Spring Boot**, and the frontend is created using **Next.js** and **Tailwind CSS**. The app leverages **Docker** for both database and Keycloak containerization to ensure easy deployment and scalability.

## Features
- **Celebrity Profiles**: View detailed profiles with their biography, career highlights, and influence.
- **Trending Celebrities**: Discover celebrities currently trending.
- **Top-Rated Celebrities**: Find the highest-rated celebrities in various professions.
- **Search Functionality**: Easily search for celebrities by name or profession.
- **Admin Access**: Secure admin login and management of celebrity data via **Keycloak** authentication.
- **API for Data Handling**: Expose RESTful endpoints to interact with the celebrity data.

## Tech Stack
- **Backend**: 
  - Spring Boot (Java 17)
  - PostgreSQL (Docker)
  - Keycloak (Docker for authentication)
- **Frontend**: 
  - Next.js (React framework)
  - Tailwind CSS (For styling)
- **DevOps**: 
  - Docker (For containerization of database and authentication services)

## Usage
- **API Endpoints**:
  - **GET `/api/celebrities`**: Fetch all celebrities.
  - **GET `/api/celebrities?profession={profession}`**: Get celebrities filtered by profession.
  - **GET `/api/celebrities?name={searchText}`**: Get celebrities by name search.
  - **POST `/api/celebrities`**: Add a new celebrity profile.
  - **PUT `/api/celebrities`**: Update an existing celebrity profile.
  - **DELETE `/api/celebrities/{celebrityName}`**: Delete a celebrity by name.

- **Frontend**:
  - The frontend makes requests to the API to display the list of celebrities, display their profiles, and allow search and filter functionality.
  - It uses **Tailwind CSS** for responsive and modern UI components.
