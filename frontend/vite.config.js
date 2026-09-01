import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],

  base: "/client-lead-management-system/",

  server: {
    port: 5173
  }
});