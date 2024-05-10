import React from 'react';
import ExpenseItem from './ExpenseItem';

const ExpenseList = ({ expenses, deleteExpense, editExpense }) => {
  const expensesJsx = expenses.map((e) => (
    <ExpenseItem
      expense={e}
      key={e.id}
      deleteExpense={deleteExpense}
      editExpense={editExpense}
    />
  ));

  return (
    <>
      <ul className='list-group'>{expensesJsx}</ul>
    </>
  );
};

export default ExpenseList;
