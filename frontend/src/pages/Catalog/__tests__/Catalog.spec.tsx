import { render, screen } from "@testing-library/react";
import { Router } from "react-router-dom";
import history from 'util/history';
import Catalog from "..";


test('should render Catalog with products', () => {
    const text = "Fazer login";
    render(
        <Router history={history}>
            <Catalog />
        </Router>
    );
    expect(screen.getByText("Catálogo de produtos")).toBeInTheDocument();
});