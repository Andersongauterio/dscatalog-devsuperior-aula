import { render, screen } from "@testing-library/react";
import history from 'util/history';
import { Router, useParams } from 'react-router-dom';
import Form from "../Form";

jest.mock('react-router-dom', () => ({
    ...jest.requireActual('react-router-dom'),
    useParams: jest.fn()
}));

describe('Product form create tests', () => {

    beforeEach(() => {
        (useParams as jest.Mock).mockReturnValue({
            productId: 'create'
        })
    })

    test('should render Form', () => {

        render(
            <Router history={history}>
                <Form />
            </Router>
        );
    });
});