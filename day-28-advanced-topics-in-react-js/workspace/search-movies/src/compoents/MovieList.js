import React, { useEffect } from 'react';
import { useSearchMoviesContext } from '../custom-hooks';
import MovieCard from './MovieCard';

const MovieList = () => {
  const { data, isLoading, searchHistory, searchMovies } =
    useSearchMoviesContext();

  const movieListJsx =
    data === null
      ? []
      : data.Search.map((m) => (
          <div className='col-md-4' key={m.imdbID}>
            <MovieCard movie={m} />
          </div>
        ));

  // this is called exactly once when the component is mounted
  useEffect(() => {
    if (searchHistory.length === 0) return;
    searchMovies(searchHistory[0]);
  }, []);

  return (
    <>
      {isLoading && (
        <div className='text-center'>
          <img src='https://cdn.pixabay.com/animation/2022/10/11/03/16/03-16-39-160_512.gif' />
        </div>
      )}
      {isLoading === false && data !== null && (
        <div className='row'>{movieListJsx}</div>
      )}
    </>
  );
};

export default MovieList;
