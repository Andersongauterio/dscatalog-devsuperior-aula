import { formatPrice } from "util/formater";

test('formatPrice should format number pt-BR when given 10.1', () => {

    const value = 10.1;
    const result = formatPrice(value);
    expect(result).toEqual("10,10");
})