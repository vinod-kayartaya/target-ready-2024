import { createContext } from 'react';
import { useLocalStorage } from './custom-hooks';

export const ExpensesContext = createContext();

const ExpensesProvider = ({ children }) => {
  // state
  const [expenses, setExpenses] = useLocalStorage('expenses', []);
  const [expenseToEdit, setExpenseToEdit] = useLocalStorage(
    'expenseToEdit',
    null
  );

  // beahavior
  const deleteExpense = (id) => {
    if (!window.confirm('Are you sure?')) return;

    const remainingExpenses = expenses.filter((exp) => exp.id !== id);
    setExpenses(remainingExpenses);
  };

  const addExpense = (expense) => {
    expense.id =
      expenses.length === 0 ? 1 : 1 + Math.max(...expenses.map((e) => e.id));
    setExpenses([expense, ...expenses]);
  };

  const editExpense = (id) => {
    console.log('got this id', id, 'for edit');
    const tmp = expenses.find((e) => e.id === id);
    setExpenseToEdit({ ...tmp });
  };

  const updateExpense = (expense) => {
    const expensesLocal = [...expenses];
    const indexToUpdate = expensesLocal.findIndex((e) => e.id === expense.id);
    if (indexToUpdate !== -1) {
      expensesLocal[indexToUpdate] = expense;
      setExpenses(expensesLocal);
    }
  };

  return (
    <ExpensesContext.Provider
      value={{
        expenses,
        expenseToEdit,
        addExpense,
        deleteExpense,
        editExpense,
        updateExpense,
        setExpenseToEdit,
      }}
    >
      {children}
    </ExpensesContext.Provider>
  );
};

export default ExpensesProvider;
