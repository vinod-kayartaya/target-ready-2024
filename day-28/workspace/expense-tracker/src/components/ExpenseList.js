import React from 'react';
import ExpenseItem from './ExpenseItem';
import { useExpensesContext } from '../custom-hooks';

const ExpenseList = () => {
  const { expenses } = useExpensesContext();

  const expensesJsx = expenses.map((e) => (
    <ExpenseItem expense={e} key={e.id} />
  ));

  return (
    <>
      <ul className='list-group'>{expensesJsx}</ul>
    </>
  );
};

export default ExpenseList;
