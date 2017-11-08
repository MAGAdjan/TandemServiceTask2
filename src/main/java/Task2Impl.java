import java.util.List;

/**
 * <h1>Задание №2</h1>
 * Реализуйте интерфейс {@link IElementNumberAssigner}.
 *
 * <p>Помимо качества кода, мы будем обращать внимание на оптимальность предложенного алгоритма по времени работы
 * с учетом скорости выполнения операции присвоения номера:
 * большим плюсом (хотя это и не обязательно) будет оценка числа операций, доказательство оптимальности
 * или указание области, в которой алгоритм будет оптимальным.</p>
 */
public class Task2Impl implements IElementNumberAssigner {

    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static final IElementNumberAssigner INSTANCE = new Task2Impl();

    /**
     *
     * @param elements элементы, которым нужно выставить номера
     */
    public void assignNumbers(final List<IElement> elements) {
        // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода, работающего за разумное время.

        // first check list for not being null or empty
        if(elements == null || elements.size() == 0) {
            return;
        }

        // get int, which is not equal to any number in list
        int unused = elements.size() != Integer.MAX_VALUE ? elements.size() : Integer.MIN_VALUE;

        // we go from the beginning of the list of IElements and repeat certain steps:
        // 1. check if list.get(counter) == counter
        // 2. if no, save element's number to separate variable (currNum) and assign unused int to current IElement number (currElement.setupNumber)
        // 3. find IElement which number is equals to counter (getElementByNumber), save it's number to separate variable (targetNum) and change it to currNum
        // 4. assign targetNum to currElement number
        for(int i = 0; i < elements.size(); i++) {
            IElement currElement = elements.get(i);
            if (currElement.getNumber() != i) {
                int currNum = currElement.getNumber();
                currElement.setupNumber(unused);
                IElement targetElem = getElementByNumber(elements, i);
                int targetNum = targetElem.getNumber();
                targetElem.setupNumber(currNum);
                currElement.setupNumber(targetNum);
            }
        }
    }

    /**
     *
     * @param elements list of elements
     * @param number number to find in list
     * @return element, which getNumber method returns number equals to @param number
     */
    public IElement getElementByNumber(List<IElement> elements, int number) {
        IElement returnElement = elements.get(0);
        for(IElement element : elements) {
            if(element.getNumber() == number){
                returnElement = element;
            }
        }
        return returnElement;
    }

}
