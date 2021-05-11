import { Bus } from "./bus";
import { Station } from "./station";

export class Route{
    id: number;
    from: Station;
    to: Station;
    buses: Bus[];
}