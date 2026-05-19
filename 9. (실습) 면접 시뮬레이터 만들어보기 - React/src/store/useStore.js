import { create } from 'zustand';

export const useStore = create((set) => ({
  history: [],
  addHistory: (item) => set((state) => ({ history: [item, ...state.history] })),
}));


