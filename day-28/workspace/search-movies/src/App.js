import React from 'react';
import SearchMoviesProvider from './SearchMoviesProvider';
import Header from './compoents/Header';
import MovieList from './compoents/MovieList';
import SearchHistory from './compoents/SearchHistory';

const App = () => {
  return (
    <SearchMoviesProvider>
      <Header />
      <div className='container'>
        <div className='row'>
          <div className='col-md-9'>
            <MovieList />
          </div>
          <div className='col-md-3'>
            <SearchHistory />
          </div>
        </div>
      </div>
    </SearchMoviesProvider>
  );
};

export default App;
