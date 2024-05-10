import { useContext, useEffect, useState } from 'react';
import { SearchMoviesContext } from '../SearchMoviesProvider';

export const useSearchMoviesContext = () => {
  return useContext(SearchMoviesContext);
};

export const useLocalStorage = (key, initialValue) => {
  const [value, setValue] = useState(() => {
    const storedValue = localStorage.getItem(key);
    return storedValue ? JSON.parse(storedValue) : initialValue;
  });

  useEffect(() => {
    localStorage.setItem(key, JSON.stringify(value));
  }, [key, value]);

  return [value, setValue];
};

export const useFetch = (url) => {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    if (url === '') return;

    setIsLoading(true);

    fetch(url)
      .then((resp) => resp.json())
      .then((data) => {
        setData(data);
        setError(null);
        setIsLoading(false);
      })
      .catch((error) => {
        setData(null);
        setError(error);
        setIsLoading(false);
      });
  }, [url]);

  return { data, error, isLoading };
};
