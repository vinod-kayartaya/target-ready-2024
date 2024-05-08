import React, { Component } from 'react';
import { useExpensesContext } from '../custom-hooks';

const Header = () => {
  const { expenses } = useExpensesContext();
  const expenseAmount =
    expenses.length === 0
      ? 0
      : expenses
          .map((e) => e.amount)
          .map(Number)
          .reduce((a, b) => a + b);

  const expensesInr = new Intl.NumberFormat('us-EN', {
    style: 'currency',
    currency: 'INR',
  }).format(expenseAmount);

  return (
    <>
      <div className='alert alert-primary'>
        <div className='container'>
          <h1>
            <i className='bi bi-piggy-bank me-3'></i>
            <span>Expense Tracker</span>
          </h1>
        </div>
      </div>
      <div className='container'>
        <p className='lead'>Total expense amount: {expensesInr}</p>
      </div>
    </>
  );
};

export default Header;
