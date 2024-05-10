// rules for a hook:
// 1. it is a function
// 2. name must start with `use` prefix
// 3. it generally makes use of builtin hooks
// 4. hooks can only be used in a functional component (not a class component)

import { useContext, useEffect, useState } from 'react';
import { ExpensesContext } from '../ExpensesProvider';

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

export const useExpensesContext = () => {
  return useContext(ExpensesContext);
};
