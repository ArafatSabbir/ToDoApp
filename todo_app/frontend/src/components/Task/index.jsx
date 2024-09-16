import { useContext } from "react";
import { twMerge } from "tailwind-merge";
import { ProviderContext } from "../provider";

function Task(props) {
  const { completeTask, deleteTask } = useContext(ProviderContext);

  return (
    <div
      className={twMerge([
        "flex flex-wrap bg-[#ffffff] justify-between content-center py-5 px-5 my-2 mx-3 rounded-lg border border-gray-300 hover:bg-gray-100 hover:cursor-pointer shadow-md",
        props.todo.completed && "disabled opacity-70",
      ])}
    >
      <div className="my-auto text-gray-600 mb-2">
        <p
          className={twMerge("font-medium", [
            props.todo.completed && "line-through font-normal text-gray-400",
          ])}
        >
          {props.todo.description}
        </p>
      </div>
      <div className="flex my-auto gap-2">
        <button
          className={twMerge([
            "capitalize bg-green-200 hover:bg-green-300 px-5 rounded-full py-2 hover:font-medium",
            props.todo.completed && "disabled opacity-70 cursor-not-allowed",
          ])}
          onClick={() => {
            completeTask(props.todo.id);
          }}
        >
          Complete
        </button>
        <button
          className="capitalize bg-red-200 hover:bg-red-300 px-5 rounded-full py-2 hover:font-medium"
          onClick={() => {
            deleteTask(props.todo.id);
          }}
        >
          Delete
        </button>
      </div>
    </div>
  );
}

export default Task;
