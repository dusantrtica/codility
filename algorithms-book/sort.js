import { mergeSortedArrays } from './data-structures/linked-list-type';

const swap = (array, i, j) => {
  const temp = array[i];
  array[i] = array[j];
  array[j] = temp;
};
const partition = (array, start, end) => {
  const midElem = Math.floor((start + end) / 2);
  const pivot = array[Math.floor(midElem)];
  let i = start;
  let j = end;

  while (i <= j) {
    while (array[i] < pivot) {
      i++;
    }
    while (array[j] > pivot) {
      j--;
    }
    if (i <= j) {
      swap(array, i, j);
      i++;
      j--;
    }
  }
  return i;
};

export const quickSort = (array = [], start = 0, end = array.length - 1) => {
  const k = partition(array, start, end);
  if (start < k - 1) {
    quickSort(array, 0, k - 1);
  }
  if (k < end) {
    quickSort(array, k, end);
  }
  return array;
};

export const mergeSort = (array = []) => {
  const n = array.length;

  if (n <= 1) {
    return array;
  }

  const middle = Math.floor(n / 2);
  const firstArray = array.slice(0, middle);
  const secondArray = array.slice(middle);

  return mergeSortedArrays(mergeSort(firstArray), mergeSort(secondArray));
};
