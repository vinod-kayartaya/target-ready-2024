import React, { useState } from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import ExpenseForm from './components/ExpenseForm';
import ExpenseList from './components/ExpenseList';

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
    <>
      <Header />
      <div style={{ minHeight: '650px' }} className='container'>
        <div className='row'>
          <div className='col-md-6 col-xs-12'>
            <ExpenseForm addExpense={addExpense} />
          </div>

          <div className='col-md-6 col-xs-12'>
            <ExpenseList expenses={expenses} deleteExpense={deleteExpense} />
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default App;
