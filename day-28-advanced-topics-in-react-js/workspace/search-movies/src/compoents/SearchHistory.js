import React from 'react';
import { useSearchMoviesContext } from '../custom-hooks';

const SearchHistory = () => {
  const {
    searchHistory,
    searchMovies,
    deleteSearchTermFromHistory,
    clearSearchHistory,
  } = useSearchMoviesContext();

  return (
    <>
      <ul className='list-group'>
        {searchHistory.map((searchTerm, index) => (
          <li key={index} className='list-group-item'>
            <span>
              <button
                className='btn btn-link'
                onClick={() => searchMovies(searchTerm)}
              >
                {searchTerm}
              </button>
            </span>
            <span className='float-end'>
              <button
                onClick={() => deleteSearchTermFromHistory(index)}
                className='btn btn-link bi bi-trash text-danger'
              ></button>
            </span>
          </li>
        ))}
      </ul>
      {searchHistory.length > 0 && (
        <button
          className='btn btn-link text-danger'
          onClick={() => clearSearchHistory()}
        >
          Remove all
        </button>
      )}
    </>
  );
};

export default SearchHistory;
