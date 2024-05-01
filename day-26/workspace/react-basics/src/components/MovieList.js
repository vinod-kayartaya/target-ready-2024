import React, { useEffect, useState } from 'react';

const MovieList = () => {
  const [movies, setMovies] = useState([]);

  const loadMovies = () => {
    console.log('loading movies...');
    // get the data from the OMDBapi.com
    // once data is available, change the state by calling setMovies(data)

    const url = 'https://omdbapi.com/?apikey=aa9e49f&s=james';

    fetch(url)
      .then((resp) => resp.json())
      .then((data) => data.Search)
      .then((movies) => setMovies(movies));
  };

  console.log('rendering the MovieList component...');

  // useEffect(callback, []) // the callback is executed exactly once after the component is mounted on the UI

  // useEffect(callback) // the callback is executed everytime there is a change in any of the state or prop

  // useEffect(callback, [deps]) // the callback is executed everytime there is a change in the dependencies (state or props)

  useEffect(() => {
    console.log('useEffect() called since the component is mounted on the UI');
    loadMovies();
  }, []);

  const moviesJsx = movies.map((movie) => (
    <div key={movie.imdbID} className='card col-3'>
      <img src={movie.Poster} className='card-img-top' alt={movie.Title} />
      <div className='card-body'>
        <h5 className='card-title'>{movie.Title}</h5>
        <p className='card-text'>Released year {movie.Year}</p>
        <p className='card-text'>Type {movie.Type}</p>
      </div>
    </div>
  ));

  return (
    <>
      <div className='row'>{moviesJsx}</div>
    </>
  );
};

export default MovieList;
