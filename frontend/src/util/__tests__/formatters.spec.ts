import { formatPrice } from "util/formater";

describe('formatPrice for positive numbers', () => {

    test('formatPrice should format number pt-BR when given 10.1', () => {
        const value = 10.1;
        const result = formatPrice(value);
        expect(result).toEqual("10,10");
    });

    test('formatPrice should format number pt-BR when given 0.1', () => {
        const value = 0.1;
        const result = formatPrice(value);
        expect(result).toEqual("0,10");
    });
});

describe('formatPrice for non-positive numbers', () => {

    test('should format number pt-BR when given 0', () => {
        const result = formatPrice(0);
        expect(result).toEqual("0,00");
    });

    test('should format number pt-BR when given -5.1', () => {
        const result = formatPrice(-5.1);
        expect(result).toEqual("-5,10");
    });
});
