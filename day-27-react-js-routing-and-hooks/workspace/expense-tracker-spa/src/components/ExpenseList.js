import React from 'react';
import ExpenseItem from './ExpenseItem';

const ExpenseList = ({ expenses, deleteExpense }) => {
  const expensesJsx = expenses.map((e) => (
    <ExpenseItem expense={e} key={e.id} deleteExpense={deleteExpense} />
  ));

  return (
    <>
      <ul className='list-group'>{expensesJsx}</ul>
    </>
  );
};

export default ExpenseList;
