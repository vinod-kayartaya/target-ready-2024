import movies from '../spiderman-movies.json';

const MoviePosters = () => {
  const moviePosters = movies.map((movie) => (
    <img
      key={movie.imdbID}
      src={movie.Poster}
      className='img-thumbnail rounded app-movie-poster'
    />
  ));

  return (
    <>
      <h3>Spiderman Movie Posters</h3>
      {moviePosters}
    </>
  );
};

export default MoviePosters;
