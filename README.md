
## PORTUGUÊS-BR
# TMDB API

Esta é uma API que fornece informações sobre filmes, incluindo:

- **Filmes por gênero**
- **Detalhes do filme**
- **Filmes mais bem avaliados**

## Tecnologias Utilizadas

Esta API foi desenvolvida utilizando as seguintes tecnologias:

- **Java 17**
- **Spring WEB:** Um framework do ecossistema Spring para desenvolvimento web, facilitando a criação de APIs RESTful.
- **Swagger:** Uma ferramenta para documentação de APIs, permitindo que desenvolvedores visualizem e interajam com os endpoints de forma fácil.
- **Lombok:** Uma biblioteca para Java que reduz a quantidade de código boilerplate, tornando o código mais conciso e legível.
- **Nginx:** Um servidor web/proxy reverso que melhora o desempenho, segurança e escalabilidade da aplicação.

## Endpoints Disponíveis

### Filmes por Gênero

- **Endpoint:** `/api/movies/genre/{nomeDoGenero}`
- **Método HTTP:** GET
- **Descrição:** Retorna uma lista de filmes com base no gênero especificado.

### Detalhes do Filme

- **Endpoint:** `/api/movies/movie/{movieId}/details`
- **Método HTTP:** GET
- **Descrição:** Retorna detalhes específicos de um filme com base no ID fornecido.

### Filmes Melhores Avaliados

- **Endpoint:** `/api/movies/top-rated`
- **Método HTTP:** GET
- **Descrição:** Retorna uma lista dos filmes mais bem avaliados.

## Executando a Aplicação

1. Clone o repositório: `git clone https://github.com/Cleverton-Rocha/Tmdb-api-java.git`
2. Navegue até o diretório do projeto: `cd tmdbapi`
3. Rode o docker-compose `docker compose up`

A aplicação estará acessível em `http://localhost:9999` + endpoints listados acima

## Bearer Token
Lembrando que você precisa ter a chave do TMDB para conseguir retornar as informações dos endpoints. Para isso, faça o cadastro em [TMDB API](https://developer.themoviedb.org/reference/intro/getting-started)
- Após fazer o cadastro é só mandar a requisição para o endpoint da aplicação com o seu Bearer token.

---

## ENGLISH-US
# TMDB API

This is an API that provides information about movies, including:

- Movies by genre
- Movie details
- Top-rated movies

## Technologies Used

This API was developed using the following technologies:

- **Java 17**
- **Spring WEB:** A framework from the Spring ecosystem for web development, facilitating the creation of RESTful APIs.
- **Swagger:** A tool for API documentation, allowing developers to visualize and interact with endpoints easily.
- **Lombok:** A Java library that reduces boilerplate code, making the code more concise and readable.
- **Nginx:** A web server/reverse proxy that improves performance, security, and scalability of the application.

## Available Endpoints

### Movies by Genre

- **Endpoint:** `/api/movies/genre/{genreName}`
- **HTTP Method:** GET
- **Description:** Returns a list of movies based on the specified genre.

### Movie Details

- **Endpoint:** `/api/movies/movie/{movieId}/details`
- **HTTP Method:** GET
- **Description:** Returns specific details of a movie based on the provided ID.

### Top-Rated Movies

- **Endpoint:** `/api/movies/top-rated`
- **HTTP Method:** GET
- **Description:** Returns a list of top-rated movies.

## Running the Application

1. Clone the repository: `git clone https://github.com/Cleverton-Rocha/Tmdb-api-java.git`
2. Navigate to the project directory: `cd tmdbapi`
3. Run the Docker Compose: `docker-compose up`
4. The application will be accessible at `http://localhost:9999` + the listed endpoints above.

## Bearer Token

Remember that you need to have a TMDB key to retrieve information from the endpoints. To obtain a key, register at [TMDB API](https://developer.themoviedb.org/reference/intro/getting-started).

After registration, send the request to the application endpoint with your Bearer token.

