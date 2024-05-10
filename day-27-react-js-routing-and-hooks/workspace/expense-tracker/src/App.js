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
  const [expenseToEdit, setExpenseToEdit] = useState(null);

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
    // TODO: update the corresponding expense in the state `expenses`
  };

  return (
    <>
      <Header />
      <div style={{ minHeight: '650px' }} className='container'>
        <div className='row'>
          <div className='col-md-6 col-xs-12'>
            <ExpenseForm
              addExpense={addExpense}
              expenseToEdit={expenseToEdit}
              setExpenseToEdit={setExpenseToEdit}
            />
          </div>

          <div className='col-md-6 col-xs-12'>
            <ExpenseList
              expenses={expenses}
              deleteExpense={deleteExpense}
              editExpense={editExpense}
            />
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default App;
