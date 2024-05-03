import React, { useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Layout from './Layout';

import ExpenseForm from './components/ExpenseForm';
import ExpenseList from './components/ExpenseList';
import About from './components/About';

const initialState = [
  {
    id: 1,
    description: 'Paid property tax',
    amount: 5378,
    date: '3/5/2024',
  },
  {
    id: 2,
    description: 'Milk tokens',
    amount: 1320,
    date: '2/5/2024',
  },
  {
    id: 3,
    description: 'Airtel internet bill',
    amount: 2278,
    date: '3/5/2024',
  },
];

const App = () => {
  // state
  const [expenses, setExpenses] = useState(initialState);

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
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route
            path='add-expense'
            element={<ExpenseForm addExpense={addExpense} />}
          />

          <Route
            path='expenses'
            element={
              <ExpenseList expenses={expenses} deleteExpense={deleteExpense} />
            }
          />

          <Route path='about' element={<About />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
