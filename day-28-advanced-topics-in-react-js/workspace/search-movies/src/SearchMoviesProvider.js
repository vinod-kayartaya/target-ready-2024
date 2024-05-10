import { createContext, useState } from 'react';
import { useFetch, useLocalStorage } from './custom-hooks';

export const SearchMoviesContext = createContext();

const SearchMoviesProvider = ({ children }) => {
  const [url, setUrl] = useState('');
  const { data, error, isLoading } = useFetch(url);
  const [searchHistory, setSearchHistory] = useLocalStorage(
    'searchHistory',
    []
  );

  const searchMovies = (searchTerm) => {
    const url = `https://www.omdbapi.com/?apikey=aa9e49f&s=${searchTerm}`;
    setUrl(url);
    const searchHistoryLocal = [...searchHistory];
    const index = searchHistoryLocal.findIndex((e) => e === searchTerm);
    if (index !== -1) {
      searchHistoryLocal.splice(index, 1);
    }

    setSearchHistory([searchTerm, ...searchHistoryLocal]);
  };

  const deleteSearchTermFromHistory = (index) => {
    const searchHistoryLocal = [...searchHistory];
    searchHistoryLocal.splice(index, 1);
    setSearchHistory(searchHistoryLocal);
  };

  const clearSearchHistory = () => {
    setSearchHistory([]);
  };

  return (
    <SearchMoviesContext.Provider
      value={{
        searchMovies,
        data,
        error,
        isLoading,
        searchHistory,
        deleteSearchTermFromHistory,
        clearSearchHistory,
      }}
    >
      {children}
    </SearchMoviesContext.Provider>
  );
};

export default SearchMoviesProvider;
