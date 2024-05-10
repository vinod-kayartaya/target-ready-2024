import React from 'react';

const ExpenseItem = ({ expense, deleteExpense, editExpense }) => {
  const deleteButtonHandler = () => {
    deleteExpense(expense.id);
  };

  const editButtonHandler = () => {
    editExpense(expense.id);
  };

  return (
    <li className='list-group-item'>
      <p>
        {expense.date}
        <span className='ms-3 lead'>{expense.description}</span>

        <span className='float-end'>
          <button
            onClick={editButtonHandler}
            className='btn btn-link bi bi-pen text-primary'
          ></button>
          <button
            onClick={deleteButtonHandler}
            className='btn btn-link bi bi-trash text-danger'
          ></button>
        </span>
      </p>
      <p></p>
      <h3>₹ {expense.amount}</h3>
    </li>
  );
};

export default ExpenseItem;
