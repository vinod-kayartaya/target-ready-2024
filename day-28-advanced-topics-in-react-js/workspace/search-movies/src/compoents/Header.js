import React, { useRef, useState } from 'react';
import { useSearchMoviesContext } from '../custom-hooks';

const Header = () => {
  const searchTermRef = useRef();
  const { searchMovies } = useSearchMoviesContext();
  const [searchTerm, setSearchTerm] = useState('');

  const submitHandler = (evt) => {
    evt.preventDefault();
    if (!searchTerm) return;
    searchMovies(searchTerm);
  };

  return (
    <>
      <div className='alert alert-primary'>
        <div className='container'>
          <div className='row'>
            <div className='col-4'>
              <h3>
                <i className='bi bi-film'></i> Search Movies
              </h3>
            </div>
            <div className='col-4'>
              <form onSubmit={submitHandler}>
                <input
                  type='search'
                  className='form-control'
                  ref={searchTermRef}
                  autoFocus
                  value={searchTerm}
                  onChange={(e) => setSearchTerm(e.target.value)}
                />
              </form>
            </div>
            <div className='col-4'>
              <h3 className='text-end'>https://vinod.co</h3>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Header;
