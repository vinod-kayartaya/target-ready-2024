import React from 'react';

const MovieCard = ({ movie }) => {
  return (
    <>
      <div className='card'>
        <img src={movie.Poster} className='card-img-top' alt={movie.Title} />
        <div className='card-body'>
          <h5 className='card-title'>{movie.Title}</h5>
          <p className='card-text'>{movie.Year}</p>
        </div>
      </div>
    </>
  );
};

export default MovieCard;
